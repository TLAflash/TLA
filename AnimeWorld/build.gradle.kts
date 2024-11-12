// use an integer for version numbers
version = 4


cloudstream {
    language = "it"
    // All of these properties are optional, you can safely remove them

    // description = "Lorem Ipsum"
     authors = listOf("Gian-Fr", "doGior")

    description = "Anime from AnimeWorld. This plugin is a fork of the AnimeWorld plugin in the ItalianProvider repo"

    /**
     * Status int as the following:
     * 0: Down
     * 1: Ok
     * 2: Slow
     * 3: Beta only
     * */
    status = 1 // will be 3 if unspecified
    tvTypes = listOf(
        "AnimeMovie",
        "Anime",
        "OVA",
    )

    iconUrl = "https://static.animeworld.so/assets/images/favicon/android-icon-192x192.png?s"
}