
import { useState } from 'react';
import { Label, TextInput, Form, Button, Select, Alert } from "@trussworks/react-uswds";

export const ProductForm = () => {

  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  function handleSubmit(e) {


    const url = "http://localhost:8080/products"; // TODO store in env file instead of hardcoding
    // prevent the page reloading
    e.preventDefault();

    // grab the data from the form
    const data = new FormData(e.target);

    const newProduct = {
        pCategory: data.get("category"),
        pQuatity: data.get("quatity"),
        pStorageLoc: data.get("storageLocation"),
        warehouse: {
          id: data.get("warehouse")
        }
    }

    e.target.reset();

    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(newProduct)
    })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData)
        setMessage("Succesfully created new product with id " + returnedData?.id)
      })
      .catch(err => {
        console.log(err);
        setError(err)
      });

  }

  return (
    <>
      <h2>Create a Product</h2>

      <Form onSubmit={handleSubmit}>
        <Label htmlFor="name">Product Category</Label>
        <TextInput id="category" name="category" type="text" />

        <div>
          <Label htmlFor="quantity">Quantity</Label>
          <TextInput id="quantity" name="quantity" type="number" />
        </div>
          
        <div>
          <Label htmlFor="storageLocation">Quantity</Label>
          <Select id="storageLocation" name="storageLocation" required>
            <option>- Select -</option>
            <option value="SB1">Football Storage Location</option>
            <option value="SB2">Basketball Storage Location</option>
            <option value="SB3">Voleyball Storage Location</option>
            <option value="SB4">Handball Storage Location</option>
            <option value="SB5">Baseball Storage Location</option>
            <option value="SB6">Scoccer Storage Location</option>
          </Select>
        </div>

        <div>
          <Label htmlFor="warehouse">Warehouse</Label>
          <Select id="warehouse" name="warehouse" required>
            <option>- Select -</option>
            <option value="DBC1">DBC1</option>
            <option value="DBC2">DBC2</option>
            <option value="DBC3">DBC3</option>
            <option value="DBC4">DBC4</option>
            <option value="DBC5">DBC5</option>
            <option value="DBC6">DBC6</option>
            <option value="DBC7">DBC7</option>
            <option value="DBC8">DBC8</option>
            <option value="DBC9">DBC9</option>
            <option value="DBC10">DBC10</option>
          </Select>
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
