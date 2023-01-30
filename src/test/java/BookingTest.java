import org.junit.Test;

public class BookingTest {

    @Test
    public void getAllBookingsById_returnOk() {
        Response response = request
                .when()
                .get("/booking")
                .then()
                .extract()
                .response();


        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void getAllBookingsByUserFirstName_BookingExists_returnOk() {
        request
                .when()
                .queryParam("firstName", "Carol")
                .get("/booking")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and()
                .body("results", hasSize(greaterThan(0)));

    }

}
