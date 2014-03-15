package member;

import java.util.Map;

@Deprecated
public abstract class Member {

    protected static Map<String, String> help, type;

    public abstract String getHelps();

    public abstract String getTypes();

    public abstract String getNotNull();

    public abstract String getTypesNotNull();

}
