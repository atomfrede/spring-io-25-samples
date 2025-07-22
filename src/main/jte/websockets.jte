@template.layout(content = @`
    <ul hx-ext="ws" ws-connect="/websockets/ws" id="news-feed"></ul>
`,
footer = @`
    <span class="footer-element"><a href="https://mastodon.social/@atomfrede">@atomfrede@mastodon.social</a></span>
    <span class="footer-element"><a href="https://2025.springio.net">#springio25</a></span>
    <span class="footer-element"><a href="https://github.com/atomfrede/spring-io-25-samples">source</a></span>
`)
