@import com.github.atomfrede.spring_io_25_samples.FormModel
@import org.springframework.validation.BindingResult

@param FormModel formModel
@param BindingResult validationResult

@template.layout(content = @`
    @template.form(formModel = formModel, validationResult = validationResult)
`,
footer = @`
    <span class="element"><a href="https://mastodon.social/@atomfrede">@atomfrede@mastodon.social</a></span>
    <span class="element"><a href="https://2025.springio.net">#springio25</a></span>
    <span class="element"><a href="https://github.com/atomfrede/spring-io-25-samples">source</a></span>
`)
