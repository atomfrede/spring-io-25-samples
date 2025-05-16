@param com.github.atomfrede.spring_io_25_samples.RealtimeService.FeedItem feedItem
<li id="news-feed" hx-swap-oob="afterbegin">
    <article>
        <header>${feedItem.author}</header>
        ${feedItem.message}
        <footer>${feedItem.timestamp.toString()}</footer>
    </article>
</li>