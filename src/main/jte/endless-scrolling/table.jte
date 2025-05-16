@import com.github.atomfrede.spring_io_25_samples.person.Person
@import org.springframework.data.domain.Page
@import gg.jte.support.ForSupport


@param Page<Person> persons

@for(var personEntry : ForSupport.of(persons.getContent()))
    @if (personEntry.isLast())
        <blockquote
                hx-get="/endless-scrolling?sort=name,desc&page=${persons.getNumber() + 1}&size=${persons.getSize()}"
                hx-trigger="intersect once"
                hx-swap="afterend"
        >
            ${personEntry.get().getQuote()}
            <footer>
                <cite>— ${personEntry.get().getName()}</cite>
            </footer>
        </blockquote>
        <hr/>
    @else
        <blockquote>
            ${personEntry.get().getQuote()}
            <footer>
                <cite>— ${personEntry.get().getName()}</cite>
            </footer>
        </blockquote>
        <hr/>
    @endif
@endfor

