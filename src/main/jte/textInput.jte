@param String label
@param String name
@param String value
@param boolean invalid
@param String validationMessage

<label>
    ${label}
    <input
            type="text"
            name="${name}"
            value="${value}"
            autocomplete="off"
            aria-invalid="${invalid}"
            aria-describedby="invalid-helper-${name}"
            hx-trigger="keyup changed delay:250ms"
            hx-post="/"
            hx-include="closest form"
            hx-target="#hx-form"
            hx-swap="morph"
    >
    @if (invalid)
        <small id="invalid-helper-${name}">
            ${validationMessage}
        </small>
    @endif
</label>

