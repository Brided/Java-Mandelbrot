package mandelbrot.image;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
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

    public void updateImage() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelWriter.setColor(x, y, Color.hsb(x, 0.5, 0.5));
            }
        }
    }

    public void resize(int newWidth, int newHeight) {
        WritableImage resizedImage = new WritableImage(newWidth, newHeight);
        PixelReader pixelReader = this.image.getPixelReader();
        PixelWriter pixelWriter = resizedImage.getPixelWriter();

        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                try {
                    int argb = pixelReader.getArgb(x, y);
                    pixelWriter.setArgb(x, y, argb);
                } catch (IndexOutOfBoundsException e) {
                    pixelWriter.setColor(x, y, Color.WHITE);
                }
            }
        }

        this.image = resizedImage;
        this.pixelWriter = pixelWriter;
        this.imageView.setImage(resizedImage);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setWidth(int width) {
        this.resize(width, height);
        this.width = width;
    }

    public void setHeight(int height) {
        this.resize(width, height);
        this.height = height;
    }
}
