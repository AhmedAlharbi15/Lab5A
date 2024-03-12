package com.example.lab5a.Controller;

import com.example.lab5a.Api.ApiResponse;
import com.example.lab5a.Model.Event;
import com.example.lab5a.Model.Project;
import com.example.lab5a.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Api/v1/event")
public class EventController {
    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> show() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event ev) {
        events.add(ev);
        return new ApiResponse("added");
    }

    @PutMapping("/update/{index}")
    public ApiResponse UpEvent(@PathVariable int index, @RequestBody Event ev) {
        events.set(index, ev);
        return new ApiResponse("Updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("delete");
    }

    @PutMapping("/change-capacity/{index}/{capacity}")
    public ApiResponse changeCap(@PathVariable int index, @PathVariable int capacity) {
        Event event = events.get(index);
        event.setCapacity(capacity);
        events.set(index, event);
        return new ApiResponse("capacity changed");
    }

    @GetMapping("/search/{id}")
    public ArrayList<Event> search(@PathVariable String id) {
        ArrayList<Event> even = new ArrayList<>();
        for (Event event : events) {
            if (event.getId().equalsIgnoreCase(id)) {
                even.add(event);
            }
        }
        return even;
    }
}
