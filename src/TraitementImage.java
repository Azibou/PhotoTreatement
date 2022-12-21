public abstract class TraitementImage {
  
  
   public static Image openFile(String fn) throws ImageFailException {
        RenderedOp ropimage; // a Rendered Operation object will contain the metadata and data
        ropimage = JAI.create("fileload", fn); // open the file
        BufferedImage bi = ropimage.getAsBufferedImage(); // BufferedImage will contain the data
        IMG_WIDTH = ropimage.getWidth(); // img width
        IMG_HEIGHT = ropimage.getHeight(); // img height
        ColorModel cm = ropimage.getColorModel();  //gray-scale or colored image ?

        //si l'image est en couleur
        if (cm.getColorSpace().getType() == ColorSpace.TYPE_RGB) {
            int[] px2;
            px2 = bi.getRGB(0, 0, IMG_WIDTH, IMG_HEIGHT, null, 0, IMG_WIDTH);
            return new Image(px2, fn);
        }

        //si l'image est en nuance de gris
        else if (bi.getType() == BufferedImage.TYPE_BYTE_GRAY && cm.getColorSpace().getType() == ColorSpace.TYPE_GRAY) {
            Raster r = ropimage.getData(); //contient les données brutes de l'image
            DataBufferByte db = (DataBufferByte) (r.getDataBuffer());
            byte[] px;
            px = db.getData();
            return new Image(px, fn);
        }
        //si l'image n'existe pas
        throw new ImageFailException(fn) ;
    }

}
