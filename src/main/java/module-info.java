module yaeger.showcase {
    requires hanyaeger;

    exports nl.han.showcase;
    exports nl.han.showcase.scenes.mapsandlegends.tilemaps.entities;
    exports nl.han.showcase.scenes.gravity.tilemaps.entities;

    opens audio;
    opens backgrounds;
    opens entities;
    opens fonts;
    exports nl.han.showcase.Birdblitz;
    exports nl.han.showcase.Birdblitz.entities;
}
