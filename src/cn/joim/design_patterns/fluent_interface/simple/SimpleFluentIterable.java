package cn.joim.design_patterns.fluent_interface.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.joim.design_patterns.fluent_interface.FluentIterable;

public class SimpleFluentIterable<E> implements FluentIterable<E> {

	private final Iterable<E> iterable;

	protected SimpleFluentIterable(Iterable<E> iterable) {
		this.iterable = iterable;
	}

	@Override
	public FluentIterable<E> filter(Predicate<? super E> predicate) {
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			E nextElement = iterator.next();
			if (!predicate.test(nextElement)) {
				iterator.remove();
			}
		}
		return this;
	}

	@Override
	public final Optional<E> first() {
		Iterator<E> resultIterator = first(1).iterator();
		return resultIterator.hasNext() ? Optional.of(resultIterator.next()) : Optional.empty();
	}

	@Override
	public final FluentIterable<E> first(int count) {
		Iterator<E> iterator = iterator();
		int currentCount = 0;
		while (iterator.hasNext()) {
			iterator.next();
			if (currentCount >= count) {
				iterator.remove();
			}
			currentCount++;
		}
		return this;
	}

	@Override
	public final Optional<E> last() {
		List<E> list = last(1).asList();
		if (list.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(list.get(0));
	}

	@Override
	public final FluentIterable<E> last(int count) {
		int remainingElementsCount = getRemainingElementsCount();
		Iterator<E> iterator = iterator();
		int currentIndex = 0;
		while (iterator.hasNext()) {
			iterator.next();
			if (currentIndex < remainingElementsCount - count) {
				iterator.remove();
			}
			currentIndex++;
		}
		return this;
	}

	public final int getRemainingElementsCount() {
		int counter = 0;
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			iterator.next();
			counter++;
		}
		return counter;
	}

	@Override
	public final <T> FluentIterable<T> map(Function<? super E, T> function) {
		List<T> temporaryList = new ArrayList<>();
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			temporaryList.add(function.apply(iterator.next()));
		}
		return from(temporaryList);
	}

	@Override
	public List<E> asList() {
		return toList(iterable.iterator());
	}

	@Override
	public Iterator<E> iterator() {
		return iterable.iterator();
	}

	@Override
	public void forEach(Consumer<? super E> action) {
		iterable.forEach(action);
	}

	@Override
	public Spliterator<E> spliterator() {
		return iterable.spliterator();
	}

	public static <E> FluentIterable<E> from(Iterable<E> iterable) {
		return new SimpleFluentIterable<>(iterable);
	}

	public static <E> FluentIterable<E> fromCopyOf(Iterable<E> iterable) {
		List<E> copy = FluentIterable.copyToList(iterable);
		return new SimpleFluentIterable<>(copy);
	}

	public static <E> List<E> toList(Iterator<E> iterator) {
		List<E> copy = new ArrayList<>();
		while (iterator.hasNext()) {
			copy.add(iterator.next());
		}
		return copy;
	}

}
