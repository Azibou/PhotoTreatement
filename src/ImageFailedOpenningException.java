class ImageFailedOpenningException {
    protected String filename;
    public ImageFailedOpenningException(String filename){
        this.filename=filename;
    }
    public String toString(){
        return filename+"n'est pas une image de tyoe png";
    }
}
