@import com.github.atomfrede.jdconf_sample.FormModel
@import org.springframework.validation.BindingResult

@param FormModel formModel
@param BindingResult validationResult

@template.layout(content = @`
    @template.form(formModel = formModel, validationResult = validationResult)
`,
footer = @`
    <span class="element"><a href="https://mastodon.social/@atomfrede">@atomfrede@mastodon.social</a></span>
    <span class="element"><a href="https://2025.springio.net">#springio25</a></span>
    <span class="element"><a href="">source</a></span>
`)
