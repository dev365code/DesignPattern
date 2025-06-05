package Bridge;

import Bridge.StudyingAPI;
import Bridge.Subject;

// RefinedAbstraction - study() 호출만 Implementor로 위임.
public class SubjectSql extends Subject {
    public SubjectSql(String name, int fromPage, int toPage, StudyingAPI api) {
        super(name, fromPage, toPage, api);
    }
    @Override
    public void study() {
        api.study(name, fromPage, toPage);
    }
}