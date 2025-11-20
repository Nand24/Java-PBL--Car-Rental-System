package service;

import model.*;
import data.FileManager;
import java.util.*;

public class BookingService {

    public void createBooking(Booking booking) {
        FileManager.writeFile("bookings.txt", booking.toString());
    }
}
