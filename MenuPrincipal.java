package com.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by adolf on 22/02/2017.
 */

public class MenuPrincipal extends PantallaBase {
    private Image menuInicio;
    private Stage stage;
    private Skin skin;
    private TextButton jugar;
    private TextButton salir;



    public MenuPrincipal(final MainGame game) {
        super(game);

        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        skin = new Skin(Gdx.files.internal("Skin/uiskin.json"));
        menuInicio = new Image(game.getManager().get("menu2.jpg", Texture.class));

        jugar = new TextButton("Jugar", skin);
        jugar.setPosition(Gdx.graphics.getWidth() / 2 -200 , Gdx.graphics.getHeight() / 2 );
        jugar.setSize(400, 200);
        jugar.setColor(255,0,0,255);

        salir = new TextButton("Salir", skin);
        salir.setPosition(Gdx.graphics.getWidth() / 2 -200 , Gdx.graphics.getHeight() / 2 - 300 );
        salir.setSize(400, 200);
        salir.setColor(255,0,0,255);

        menuInicio.setPosition(Gdx.graphics.getWidth() / 2 - menuInicio.getWidth() / 2, Gdx.graphics.getHeight() / 2 - menuInicio.getHeight() / 2);
        stage.addActor(menuInicio);
        stage.addActor(jugar);
        stage.addActor(salir);

        jugar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.mainGameScreen);
            }
        });

        salir.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.exit(0);
            }
        });
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
