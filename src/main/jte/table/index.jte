@import com.github.atomfrede.spring_io_25_samples.person.Person
@import com.github.atomfrede.spring_io_25_samples.pagination.PagerModel
@import org.springframework.data.domain.Page
@import java.util.Locale

@param Page<Person> persons
@param PagerModel pager
@param String q

!{var currentSort=persons.getPageable().getSort().toString().replace(": ", ",").trim().toLowerCase(Locale.ROOT);}

@template.layout(content = @`
    <div>
        <div class="filter">
            <input type="text"
                   name="q"
                   placeholder="Type to search..."
                   hx-get="/tables?size=${persons.getPageable().getPageSize()}&page=0&sort=${currentSort}"
                   hx-push-url="true"
                   hx-target="#table-wrapper"
                   hx-trigger="input changed delay:500ms, keyup[key=='Enter']"
            />

        </div>
        <div id="total-count">${persons.getTotalElements()}</div>
        <div id="table-wrapper">
            @template.table.table(persons = persons, pager =pager, q = q)
        </div>
    </div>
`)
