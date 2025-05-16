@import com.github.atomfrede.jdconf_sample.person.Person
@import com.github.atomfrede.jdconf_sample.pagination.PagerModel
@import org.springframework.data.domain.Page

@param Page<Person> persons
@param PagerModel pager

@template.layout(content = @`
    <div id="table-wrapper">
        @template.table.table(persons = persons, pager =pager)
    </div>
`,
footer = @`
    <span class="element"><a href="https://mastodon.social/@atomfrede">@atomfrede@mastodon.social</a></span>
    <span class="element"><a href="https://2025.springio.net">#springio25</a></span>
    <span class="element"><a href="">source</a></span>
`)
