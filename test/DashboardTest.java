import com.fasterxml.jackson.databind.JsonNode;
import io.backend.api.model.Dashboard;
import io.backend.api.model.User;
import io.backend.api.utils.DatabaseUtils;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.*;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

public class DashboardTest extends WithApplication {

    String token;

    @Before
    public void setUp() {

        User user = new User("urim", "password", null);
        user.setId(new ObjectId("62e257f6dbff353f56ef3024"));
        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("POST")
                .uri("/api/user/")
                .bodyJson(Json.toJson(user));
        final Result result = route(app, homeRequest);
        assertEquals(OK, result.status());


        final Http.RequestBuilder homeRequest2 = new Http.RequestBuilder()
                .method("POST").uri("/api/authenticate/")
                .bodyJson(Json.toJson(user));
        final Result result1 = route(app, homeRequest2);
        token = Json.parse(contentAsString(result1)).asText();


        List<Dashboard> list = new ArrayList<>();

        Dashboard dashboard1 = new Dashboard("Tools", "e-enable innovative channels", null, List.of("62ea2bbc21982230a035bdc0", "62ea2bab12d9a44c9e2c1485"), List.of("62ea2bc0b826c8c660a552e6", "62e90a944e9bf2171ca6df26"), null, null, null);
        dashboard1.setId(new ObjectId("62ea320afc13ae31a1000136"));
        list.add(dashboard1);

        Dashboard dashboard2 = new Dashboard("Kids", "utilize cross-platform action-items", new ObjectId("62ea320afc13ae31a1000136"), List.of("62e257f6dbff353f56ef3024", "62ea2bbc21982230a035bdc0"), List.of("62ea2bbc21982230a035bdc0", "62ea2bb98f2b3cbbd9d853de"), null, null, null);
        dashboard1.setId(new ObjectId("62ea320afc13ae31a1000137"));
        list.add(dashboard2);

        Dashboard dashboard3 = new Dashboard("Toys", "matrix visionary networks", new ObjectId("62ea320afc13ae31a1000137"), List.of("62e7dc19bcae4f4a49908dca", "62e257f6dbff353f56ef3025"), List.of("62e90a69e08d17cd567438dd", "62ea2bb52198b55274b88afa"), null, null, null);
        dashboard1.setId(new ObjectId("62ea320afc13ae31a1000138"));
        list.add(dashboard3);

        Dashboard dashboard4 = new Dashboard("Beauty", "maximize vertical supply-chains", new ObjectId("62ea320afc13ae31a1000137"), List.of("62e257f6dbff353f56ef3025", "62ea2bb52198b55274b88afa"), List.of("62e7dc19bcae4f4a49908dca"), null, null, null);
        dashboard1.setId(new ObjectId("62ea320afc13ae31a1000139"));
        list.add(dashboard4);

        Dashboard dashboard5 = new Dashboard("Automotive", "optimize intuitive interfaces", new ObjectId("62ea320afc13ae31a1000139"), List.of("62e7dc19bcae4f4a49908dca", "62e90a69e08d17cd567438dd"), List.of("62ea2bb52198b55274b88afa", "62ea2bbc21982230a035bdc0"), null, null, null);
        dashboard1.setId(new ObjectId("62ea320afc13ae31a100013a"));
        list.add(dashboard5);

        for (Dashboard dashboard : list) {
            final Http.RequestBuilder homeRequest3 = new Http.RequestBuilder()
                    .method("POST")
                    .uri("/api/dashboard/")
                    .header("token", token)
                    .bodyJson(Json.toJson(dashboard));
            final Result result2 = route(app, homeRequest3);
            assertEquals(OK, result2.status());
        }

    }


    @Test
    public void testRead() {
        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("GET")
                .header("token", token)
                .uri("/api/dashboard/")
                .bodyJson(Json.toJson(""));
        final Result result = route(app, homeRequest);
        assertEquals(OK, result.status());

        JsonNode body = Json.parse(contentAsString(result));
        List<Dashboard> resultList = DatabaseUtils.parseJsonListOfType(body, Dashboard.class);
        assertTrue(resultList.size() != 0);
    }

    @Test
    public void testRead2() {
        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("GET")
                .header("token", "")
                .uri("/api/dashboard/")
                .bodyJson(Json.toJson(""));
        final Result result = route(app, homeRequest);
        assertEquals(BAD_REQUEST, result.status());
    }

    @Test
    public void testSave() {
        Dashboard dashboard = new Dashboard("Automotive", "optimize intuitive interfaces", new ObjectId("62ea320afc13ae31a1000139"), List.of("62e7dc19bcae4f4a49908dca", "62e90a69e08d17cd567438dd"), List.of("62e90a69e08d17cd567438dd", "62ea2bbc21982230a035bdc0"), new ArrayList<>(), new ArrayList<>(), null);
        dashboard.setId(new ObjectId("62ea320afc13ae31a1000400"));

        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("POST")
                .header("token", token)
                .uri("/api/dashboard/")
                .bodyJson(Json.toJson(dashboard));
        final Result result = route(app, homeRequest);
        assertEquals(OK, result.status());

        JsonNode body = Json.parse(contentAsString(result));
        Dashboard result2 = Json.fromJson(body, Dashboard.class);
        assertEquals(dashboard, result2);
    }

    @Test
    public void testSave2() {
        Dashboard dashboard = new Dashboard();
        dashboard.setDescription("optimize intuitive interfaces");
        dashboard.setId(new ObjectId("62ea320afc13ae31a1000400"));

        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("POST")
                .header("token", token)
                .uri("/api/dashboard/")
                .bodyJson(Json.toJson(dashboard));
        final Result result = route(app, homeRequest);
        assertEquals(BAD_REQUEST, result.status());
    }


    @Test
    public void testUpdate(){
        Dashboard dashboard = new Dashboard("Automotiveeeeee", "optimize intuitive interfaces", new ObjectId("62ea320afc13ae31a1000139"), List.of("62e7dc19bcae4f4a49908dca", "62e90a69e08d17cd567438dd"), List.of("62e90a69e08d17cd567438dd", "62ea2bbc21982230a035bdc0"), new ArrayList<>(), new ArrayList<>(), null);

        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("PUT")
                .uri("/api/dashboard/62ea320afc13ae31a1000400")
                .header("token", token)
                .bodyJson(Json.toJson(dashboard));
        final Result result = route(app, homeRequest);
        assertEquals(OK, result.status());

        JsonNode body = Json.parse(contentAsString(result));
        Dashboard result2 = Json.fromJson(body, Dashboard.class);
        assertEquals(dashboard, result2);
    }

    @Test
    public void testUpdate2(){
        Dashboard dashboard = new Dashboard();
        dashboard.setDescription("optimize intuitive interfaces");

        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("PUT")
                .header("token", token)
                .uri("/api/dashboard/62ea320afc13ae31a1000400")
                .bodyJson(Json.toJson(dashboard));
        final Result result = route(app, homeRequest);
        assertEquals(BAD_REQUEST, result.status());
    }

    @Test
    public void testDelete(){
        Dashboard dashboard = new Dashboard("Automotiveeeeee", "optimize intuitive interfaces", new ObjectId("62ea320afc13ae31a1000139"), List.of("62e7dc19bcae4f4a49908dca", "62e90a69e08d17cd567438dd"), List.of("62e90a69e08d17cd567438dd", "62ea2bbc21982230a035bdc0"), new ArrayList<>(), new ArrayList<>(), null);

        final Http.RequestBuilder homeRequest = new Http.RequestBuilder()
                .method("DELETE")
                .uri("/api/dashboard/62ea320afc13ae31a1000400")
                .header("token", token)
                .bodyJson(Json.toJson(dashboard));
        final Result result = route(app, homeRequest);
        assertEquals(OK, result.status());

    }
}
