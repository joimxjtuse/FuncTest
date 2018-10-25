package cn.joim.design_patterns.fluent_interface.lazy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.joim.design_patterns.fluent_interface.FluentIterable;

public class LazyFluentIterable<E> implements FluentIterable<E> {

	private final Iterable<E> iterable;

	protected LazyFluentIterable(Iterable<E> iterable) {
		this.iterable = iterable;
	}

	protected LazyFluentIterable() {
		iterable = this;
	}

	@Override
	public FluentIterable<E> filter(Predicate<? super E> predicate) {
		return new LazyFluentIterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return new DecoratingIterator<E>(iterable.iterator()) {
					@Override
					public E computeNext() {
						while (fromIterator.hasNext()) {
							E candidate = fromIterator.next();
							if (predicate.test(candidate)) {
								return candidate;
							}
						}

						return null;
					}
				};
			}
		};
	}

	@Override
	public Optional<E> first() {
		Iterator<E> resultIterator = first(1).iterator();
		return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
	}

	@Override
	public FluentIterable<E> first(int count) {
		return new LazyFluentIterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return new DecoratingIterator<E>(iterable.iterator()) {
					int currentIndex;

					@Override
					public E computeNext() {
						if (currentIndex < count && fromIterator.hasNext()) {
							E candidate = fromIterator.next();
							currentIndex++;
							return candidate;
						}
						return null;
					}
				};
			}
		};
	}

	@Override
	public Optional<E> last() {
		Iterator<E> resultIterator = last(1).iterator();
		return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
	}

	@Override
	public FluentIterable<E> last(int count) {
		return new LazyFluentIterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return new DecoratingIterator<E>(iterable.iterator()) {
					private int stopIndex;
					private int totalElementsCount;
					private List<E> list;
					private int currentIndex;

					@Override
					public E computeNext() {
						initialize();

						E candidate = null;
						while (currentIndex < stopIndex && fromIterator.hasNext()) {
							currentIndex++;
							fromIterator.next();
						}
						if (currentIndex >= stopIndex && fromIterator.hasNext()) {
							candidate = fromIterator.next();
						}
						return candidate;
					}

					private void initialize() {
						if (list == null) {
							list = new ArrayList<>();
							Iterator<E> newIterator = iterable.iterator();
							while (newIterator.hasNext()) {
								list.add(newIterator.next());
							}

							totalElementsCount = list.size();
							stopIndex = totalElementsCount - count;
						}
					}
				};
			}
		};
	}

	@Override
	public <T> FluentIterable<T> map(Function<? super E, T> function) {
		return new LazyFluentIterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new DecoratingIterator<T>(null) {
					Iterator<E> oldTypeIterator = iterable.iterator();

					@Override
					public T computeNext() {
						if (oldTypeIterator.hasNext()) {
							E candidate = oldTypeIterator.next();
							return function.apply(candidate);
						} else {
							return null;
						}
					}
				};
			}
		};
	}

	@Override
	public List<E> asList() {
		return FluentIterable.copyToList(iterable);
	}

	@Override
	public Iterator<E> iterator() {
		return new DecoratingIterator<E>(iterable.iterator()) {
			@Override
			public E computeNext() {
				return fromIterator.hasNext() ? fromIterator.next() : null;
			}
		};
	}

	public static final <E> FluentIterable<E> from(Iterable<E> iterable) {
		return new LazyFluentIterable<>(iterable);
	}

}
