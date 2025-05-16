@import com.github.atomfrede.jdconf_sample.FormModel
@import org.springframework.validation.BindingResult

@param FormModel formModel
@param BindingResult validationResult

@template.layout(content = @`
    @template.form(formModel = formModel, validationResult = validationResult)
`)
