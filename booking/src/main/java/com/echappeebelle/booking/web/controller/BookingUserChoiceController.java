package com.echappeebelle.booking.web.controller;

import com.echappeebelle.booking.model.BookingUserVehicleCheck;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingUserChoiceController {

    private final BookingUserChoiceController bookingUserChoiceController;


    public BookingUserChoiceController(BookingUserChoiceController bookingUserChoiceController) {
        this.bookingUserChoiceController = bookingUserChoiceController;
    }

    @PostMapping("/booking/choiceuser")
    public boolean checkUserVehicle(@RequestBody BookingUserVehicleCheck bookingUserVehicleCheck) {
        return bookingUserChoiceController.checkUserVehicle(bookingUserVehicleCheck);
    }

}
