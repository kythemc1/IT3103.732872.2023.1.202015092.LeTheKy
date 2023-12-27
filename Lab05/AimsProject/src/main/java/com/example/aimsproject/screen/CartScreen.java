package com.example.aimsproject.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;


import com.example.aimsproject.aims.Aims;
import com.example.aimsproject.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1080, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/aimsproject/Cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    public static void main(String[] args) throws LimitExceededException {
        Aims.init();
        Aims.cart.addMedia(Aims.store.getItemsInStore());
        new CartScreen(Aims.cart);
    }
}