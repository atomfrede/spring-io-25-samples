@import com.github.atomfrede.spring_io_25_samples.person.Person
@import com.github.atomfrede.spring_io_25_samples.pagination.PagerModel
@import org.springframework.data.domain.Page
@import gg.jte.support.ForSupport
@import java.util.Locale

@param Page<Person> persons
@param PagerModel pager

<table hx-target="#table-wrapper" hx-push-url="true" class="striped">
    <thead>
    <tr>
        <th scope="col">
            @if (persons.getSort().getOrderFor("name") != null && persons.getSort().getOrderFor("name").isDescending())
            <div
                    hx-get="/tables?sort=name,asc&size=${persons.getPageable().getPageSize()}&page=${persons.getPageable().getPageNumber()}">
                Name (V)
            </div>
            @endif
            @if (persons.getSort().getOrderFor("name") != null && persons.getSort().getOrderFor("name").isAscending())
                <div
                        hx-get="/tables?sort=name,desc&size=${persons.getPageable().getPageSize()}&page=${persons.getPageable().getPageNumber()}"
                >
                    Name (^)
                </div>
            @endif
        </th>
        <th scope="col">Quote</th>
    </tr>
    </thead>
    <tbody>
    @for(var personEntry : ForSupport.of(persons.getContent()))
        <tr>
            <th scope="row">${personEntry.get().getName()}</th>
            <td>${personEntry.get().getQuote()}</td>
        </tr>
    @endfor
    </tbody>
</table>

<div role="group" hx-target="#table-wrapper" hx-push-url="true">
    @if (persons.hasPrevious())
        <button
                hx-get="/tables?size=${persons.getPageable().getPageSize()}&sort=${persons.getPageable().getSort().toString().replace(": ", ",").trim().toLowerCase(Locale.ROOT)}&page=${persons.getPageable().getPageNumber()-1}"
        >Prev
        </button>
    @else
        <button disabled>Prev</button>
    @endif

    @if (persons.getPageable().getPageNumber() + 1 - pager.getButtonsToShow() >=1)
        <button
                hx-get="/tables?size=${persons.getPageable().getPageSize()}&sort=${persons.getPageable().getSort().toString().replace(": ", ",").trim().toLowerCase(Locale.ROOT)}&page=${persons.getPageable().getPageNumber()-pager.getButtonsToShow()}"
        >...
        </button>
    @endif

    @for(int i = pager.getStartPage(); i<=pager.getEndPage(); i++)
        <button
                hx-get="/tables?size=${persons.getPageable().getPageSize()}&sort=${persons.getPageable().getSort().toString().replace(": ", ",").trim().toLowerCase(Locale.ROOT)}&page=${i}"
        >
            ${i}
        </button>
    @endfor

    @if (persons.getPageable().getPageNumber() + 1 + pager.getButtonsToShow() <= persons.getTotalPages())
        <button
                hx-get="/tables?size=${persons.getPageable().getPageSize()}&sort=${persons.getPageable().getSort().toString().replace(": ", ",").trim().toLowerCase(Locale.ROOT)}&page=${persons.getPageable().getPageNumber()+pager.getButtonsToShow()}"

        >...
        </button>
    @endif

    @if (persons.hasNext())
        <button
                hx-get="/tables?size=${persons.getPageable().getPageSize()}&sort=${persons.getPageable().getSort().toString().replace(": ", ",").trim().toLowerCase(Locale.ROOT)}&page=${persons.getPageable().getPageNumber()+1}"

        >Next
        </button>
    @else
        <button disabled>Next</button>
    @endif
</div>