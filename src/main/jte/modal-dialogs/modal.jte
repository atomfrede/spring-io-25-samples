@param String fact

<div x-data="{}">
    <dialog id="modal-example" open>
        <article>
            <header>
                <button
                        aria-label="Close"
                        rel="prev"
                        @click="closeModal"
                ></button>
                <h3>Enjoy this random fact!</h3>
            </header>
            <p>
                ${fact}
            </p>
            <footer>
                <button
                        role="button"
                        class="secondary"
                        @click="closeModal"
                >
                    Cancel
                </button
                >
                <button autofocus @click="closeModal" hx-get="/modal-dialogs/confirm">
                    Confirm
                </button>
            </footer>
        </article>
    </dialog>
    <script>
        function closeModal(e) {
            document.getElementById("modal-example").removeAttribute("open");
        }
    </script>
</div>