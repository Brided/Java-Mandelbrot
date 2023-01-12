package mandelbrot.image;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Mandelbrot {
    private ImageView imageView;

    private WritableImage image;
    private PixelWriter pixelWriter;

    private int width;
    private int height;

    public Mandelbrot(int width, int height) {
        this.width = width;
        this.height = height;

        this.image = new WritableImage(width, height);
        this.pixelWriter = this.image.getPixelWriter();

        this.imageView = new ImageView(image);
    }

    public void paintBlack() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelWriter.setColor(x, y, Color.rgb(0, 0, 0));
            }
        }
    }

    public ImageView getImageView() {
        return imageView;
    }
}
