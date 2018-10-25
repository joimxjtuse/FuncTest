package cn.joim.design_patterns.fluent_interface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FluentIterable<E> extends Iterable<E> {

	FluentIterable<E> filter(Predicate<? super E> predicate);

	Optional<E> first();

	FluentIterable<E> first(int count);

	Optional<E> last();

	FluentIterable<E> last(int count);

	<T> FluentIterable<T> map(Function<? super E, T> function);

	List<E> asList();

	static <E> List<E> copyToList(Iterable<E> iterable) {
		List<E> copy = new ArrayList<>();
		Iterator<E> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			copy.add(iterator.next());
		}
		return copy;
	}

}
