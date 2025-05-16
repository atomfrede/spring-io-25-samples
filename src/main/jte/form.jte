@import com.github.atomfrede.spring_io_25_samples.FormModel
@import org.springframework.validation.BindingResult

@param FormModel formModel
@param BindingResult validationResult

<form action="/" method="post" id="hx-form">
    <fieldset>
        @template.textInput(label = "First name", name = "firstName", value = formModel.firstName, invalid = validationResult != null && validationResult.hasFieldErrors("firstName"), validationMessage = validationResult == null || (validationResult != null && validationResult.getFieldError("firstName") == null)? "": validationResult.getFieldError("firstName").getDefaultMessage())
    </fieldset>
    <fieldset>
        @template.textInput(label = "Last name", name = "lastName", value = formModel.lastName, invalid = validationResult != null && validationResult.hasFieldErrors("lastName"), validationMessage = validationResult == null || (validationResult != null && validationResult.getFieldError("lastName") == null)? "": validationResult.getFieldError("lastName").getDefaultMessage())
    </fieldset>
    <fieldset>
        @template.textInput(label = "Talk", name = "talk", value = formModel.talk, invalid = validationResult != null && validationResult.hasFieldErrors("talk"), validationMessage = validationResult == null || (validationResult != null && validationResult.getFieldError("talk") == null) ? "": validationResult.getFieldError("talk").getDefaultMessage())
    </fieldset>
    <button
            type="submit"
            value="Submit"
    >Submit
    </button>
</form>