@import com.github.atomfrede.jdconf_sample.person.Person
@import org.springframework.data.domain.Page

@param Page<Person> persons

@template.layout(content = @`
    @template.endless-scrolling.table(persons = persons)
`)