
@param String modalConfirmed

@template.layout(content = @`
    <div>
        <button
                hx-get="/modal-dialogs"
                hx-target="#modals-here"
                hx-trigger="click"
                class="btn primary">Open Modal</button>

        <div id="modals-here"></div>


        <div id="alert">${modalConfirmed}</div>
    </div>
`,
footer = @`
    <span class="element"><a href="https://mastodon.social/@atomfrede">@atomfrede@mastodon.social</a></span>
    <span class="element"><a href="https://2025.springio.net">#springio25</a></span>
    <span class="element"><a href="">source</a></span>
`)