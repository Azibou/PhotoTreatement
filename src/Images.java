public class Images {
    protected String filename;// Correspend à le nom de ficheir

    protected boolean isColered; // Il va nous permettre de savoir si l'image en couleur ou non

    protected byte [] pixelGrey;// tableau represante les pixels d'une image sur une échelle de gris
    // tableau
    protected int [] pixelColore;//tableau represante les pixels d'une image coloré
    /**
     *Constructeur pour une image en échelle de gris.
     * @param pixel correspond au tableau represantant l'image en couleur.
     * @param filename correspond au nom de fichier.
     */
    public Images(byte [] pixel, String filename){
        this.pixelGrey=pixel;
        this.filename=filename;
        isColered=false;
        this.pixelColore=null;

    }

    /**
     *Constructeur pour une image en couleur.
     * @param pixel correspond au tableau represantant l'image en couleur.
     * @param filename correspond au nom de fichier.
     */

    public Images(int [] pixel, String filename){
        this.pixelColore=pixel;
        this.filename=filename;
        isColered=true;
        this.pixelGrey=null;
    }

    /**
     * getType une methode qui renvoie true si l'image est colorée,false sinon.
     * @return boolean qui représent la nature de l'image.
     */

    public boolean getType(){
        return this.isColered;
    }
}
