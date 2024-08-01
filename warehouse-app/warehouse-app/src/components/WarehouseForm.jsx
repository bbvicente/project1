
import { useState } from 'react';
import { Label, TextInput, Form, Button, Select, Alert } from "@trussworks/react-uswds";

export const WarehouseForm = () => {

  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  function handleSubmit(e) {


    const url = "http://localhost:8080/warehouses"; // TODO store in env file instead of hardcoding
    // prevent the page reloading
    e.preventDefault();

    // grab the data from the form
    const data = new FormData(e.target);

    const newWarehouse = {
        whName: data.get("name"),
        whCity: data.get("city"),
        whState: data.get("state"),
        whCapacity: data.get("cappacity")
    }

    e.target.reset();

    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(newWarehouse)
    })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData)
        setMessage("Succesfully created new warehouse with id " + returnedData?.id)
      })
      .catch(err => {
        console.log(err);
        setError(err)
      });

  }

  return (
    <>
      <h2>Create a Warehouse</h2>

      <Form onSubmit={handleSubmit}>
        <Label htmlFor="name">Warehouse Name</Label>
        <TextInput id="name" name="name" type="text" />

        <div>
          <Label htmlFor="city">City</Label>
          <TextInput id="city" name="city" type="text" />
        </div>

        <div>
            <Label htmlFor="state" requiredMarker>
            State, territory, or military post
            </Label>
            <Select id="state" name="state" required>
                <option>- Select -</option>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
                <option value="AA">AA - Armed Forces Americas</option>
                <option value="AE">AE - Armed Forces Africa</option>
                <option value="AE">AE - Armed Forces Canada</option>
                <option value="AE">AE - Armed Forces Europe</option>
                <option value="AE">AE - Armed Forces Middle East</option>
                <option value="AP">AP - Armed Forces Pacific</option>
            </Select>
        </div>

        <div>
          <Label htmlFor="capacity">Capacity</Label>
          <TextInput id="capacity" name="capacity" type="number" />
        </div>

        <Button type="submit">Submit</Button>

      </Form>
      {
        // TODO choose a nicer alert with a close button
        // make sure to reset the message and error state
        message && <Alert type="success" heading="Success status" headingLevel="h4">
          {message}
        </Alert>
      }

    </>
  )
}