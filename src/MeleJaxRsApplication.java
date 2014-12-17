import org.restlet.Context;
import org.restlet.ext.jaxrs.JaxRsApplication;

public class MeleJaxRsApplication extends JaxRsApplication {

    public MeleJaxRsApplication(Context context) {
        super(context);
        this.add(new MeleApplication());
    }
}