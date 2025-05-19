<div x-data="{}">
    <dialog id="modal-example" open>
        <article>
            <header>
                <button
                        aria-label="Close"
                        rel="prev"
                        @click="closeModal"
                ></button>
                <h3>Confirm your action!</h3>
            </header>
            <p>
                Cras sit amet maximus risus. Pellentesque sodales odio sit amet augue finibus
                pellentesque. Nullam finibus risus non semper euismod.
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