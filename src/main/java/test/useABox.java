package test;

import javax.inject.Inject;

/**
 * Created by dw on 2016. 3. 22..
 */
public class useABox {
    @Inject
    public ABox aBox;

    public void d() {
        System.out.println(aBox.getClass());
    }
}
