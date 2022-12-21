public abstract class TraitementImage {
   protected Image img;
   protected Scanner s;
   protected static int IMG_WIDTH;
   protected static int IMG_HEIGHT;
  
   public static Image openFile(String fn) throws ImageFailException {
        RenderedOp ropimage;
        ropimage = JAI.create("fileload", fn); 
        BufferedImage bi = ropimage.getAsBufferedImage(); 
        IMG_WIDTH = ropimage.getWidth(); // 
        IMG_HEIGHT = ropimage.getHeight(); // 
        ColorModel cm = ropimage.getColorModel();  

        
        if (cm.getColorSpace().getType() == ColorSpace.TYPE_RGB) {
            int[] px2;
            px2 = bi.getRGB(0, 0, IMG_WIDTH, IMG_HEIGHT, null, 0, IMG_WIDTH);
            return new Image(px2, fn);
        }

        
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
