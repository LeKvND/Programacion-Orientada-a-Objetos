import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
public class SolarSis {
public SolarSis(){
	BranchGroup group = new BranchGroup();

	Appearance appsol = new Appearance();
	Appearance appearth = new Appearance();
	Appearance appmercury = new Appearance();
	Appearance appvenus = new Appearance();
	Appearance appmarte = new Appearance();
	Appearance appjupiter = new Appearance();
	Appearance appsaturno = new Appearance();
	Appearance appurano = new Appearance();
	Appearance appneptuno = new Appearance();

  TextureLoader tex=new TextureLoader("TIERRA.JPG", null);
	appearth.setTexture(tex.getTexture());
	tex=new TextureLoader("SOL.JPG", null);
	appsol.setTexture(tex.getTexture());
	tex=new TextureLoader("MERCURIO.JPG", null);
	appmercury.setTexture(tex.getTexture());
	tex=new TextureLoader("VENUS.JPG", null);
	appvenus.setTexture(tex.getTexture());
	tex=new TextureLoader("MARTE.JPG", null);
	appmarte.setTexture(tex.getTexture());
	tex=new TextureLoader("JUPITER.JPG", null);
	appjupiter.setTexture(tex.getTexture());
	tex=new TextureLoader("SATURNO.JPG", null);
	appsaturno.setTexture(tex.getTexture());
	tex=new TextureLoader("URANO.JPG", null);
	appurano.setTexture(tex.getTexture());
	tex=new TextureLoader("NEPTUNO.JPG", null);
	appneptuno.setTexture(tex.getTexture());

	Sphere earth = new Sphere(0.0144f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appearth);
	Sphere mercury = new Sphere(0.0056f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appmercury);
	Sphere venus = new Sphere(0.0136f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appvenus);
	Sphere marte = new Sphere(0.0072f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appmarte);
	Sphere jupiter = new Sphere(0.040f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appjupiter);
	Sphere saturno = new Sphere(0.030f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appsaturno);
	Sphere urano = new Sphere(0.014f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appurano);
	Sphere neptuno = new Sphere(0.014f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appneptuno);
	Sphere sol = new Sphere(0.2f, Primitive.GENERATE_NORMALS |
	Primitive.GENERATE_TEXTURE_COORDS, 32, appsol);

	TransformGroup earthRotXformGroup = Posi.rotate(earth, new Alpha(-1, 1250));
	TransformGroup mercuryRotXformGroup = Posi.rotate(mercury, new Alpha(-1, 2000));
	TransformGroup venusRotXformGroup = Posi.rotate(venus, new Alpha(-1, 550));
	TransformGroup marteRotXformGroup = Posi.rotate(marte, new Alpha(-1, 1250));
	TransformGroup jupiterRotXformGroup = Posi.rotate(jupiter, new Alpha(-1, 750));
	TransformGroup saturnoRotXformGroup = Posi.rotate(saturno, new Alpha(-1, 870));
	TransformGroup uranoRotXformGroup = Posi.rotate(urano, new Alpha(-1, 600));
	TransformGroup neptunoRotXformGroup = Posi.rotate(neptuno, new Alpha(-1, 750));
	TransformGroup solRotXformGroup = Posi.rotate(sol, new Alpha(-1, 2250));

	TransformGroup earthTransXformGroup = Posi.translate(earthRotXformGroup,
	new Vector3f(0.0f, 0.0f, 0.7f));
	TransformGroup mercuryTransXformGroup = Posi.translate(mercuryRotXformGroup,
	new Vector3f(0.0f, 0.0f, 0.3f));
	TransformGroup venusTransXformGroup = Posi.translate(venusRotXformGroup,
	new Vector3f(0.0f, 0.0f, 0.5f));
	TransformGroup marteTransXformGroup = Posi.translate(marteRotXformGroup,
	new Vector3f(0.0f, 0.0f, 0.9f));
	TransformGroup jupiterTransXformGroup = Posi.translate(jupiterRotXformGroup,
	new Vector3f(0.0f, 0.0f, 1.2f));
	TransformGroup saturnoTransXformGroup = Posi.translate(saturnoRotXformGroup,
	new Vector3f(0.0f, 0.0f, 1.7f));
	TransformGroup uranoTransXformGroup = Posi.translate(uranoRotXformGroup,
	new Vector3f(0.0f, 0.0f, 2.1f));
	TransformGroup neptunoTransXformGroup = Posi.translate(neptunoRotXformGroup,
	new Vector3f(0.0f, 0.0f, 2.4f));

TransformGroup earthRotGroupXformGroup = Posi.rotate(earthTransXformGroup, new Alpha(-1, 5000));
TransformGroup mercuryRotGroupXformGroup = Posi.rotate(mercuryTransXformGroup, new Alpha(-1, 1000));
TransformGroup venusRotGroupXformGroup = Posi.rotate(venusTransXformGroup, new Alpha(-1, 3500));
TransformGroup marteRotGroupXformGroup = Posi.rotate(marteTransXformGroup, new Alpha(-1, 10000));
TransformGroup jupiterRotGroupXformGroup = Posi.rotate(jupiterTransXformGroup, new Alpha(-1, 60000));
TransformGroup saturnoRotGroupXformGroup = Posi.rotate(saturnoTransXformGroup, new Alpha(-1, 145000));
TransformGroup uranoRotGroupXformGroup = Posi.rotate(uranoTransXformGroup, new Alpha(-1, 420000));
TransformGroup neptunoRotGroupXformGroup = Posi.rotate(neptunoTransXformGroup, new Alpha(-1, 820000));


    	group.addChild(earthRotGroupXformGroup);
			group.addChild(mercuryRotGroupXformGroup);
			group.addChild(venusRotGroupXformGroup);
			group.addChild(marteRotGroupXformGroup);
			group.addChild(jupiterRotGroupXformGroup);
			group.addChild(saturnoRotGroupXformGroup);
			group.addChild(uranoRotGroupXformGroup);
			group.addChild(neptunoRotGroupXformGroup);
    	group.addChild(solRotXformGroup);

    	GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
    	Canvas3D canvas = new Canvas3D(config); canvas.setSize(400, 400);
    	SimpleUniverse universe = new SimpleUniverse(canvas);
    	universe.getViewingPlatform().setNominalViewingTransform();
    	universe.addBranchGraph(group);
    	JFrame f = new JFrame("Planetario");
    	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	f.add(canvas); f.pack(); f.setVisible(true); }
public static void main(String a[]) { new SolarSis();}
}
