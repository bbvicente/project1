
import { useState } from 'react';
import { Label, TextInput, Form, Button, Alert } from "@trussworks/react-uswds";

export const ProductForm = () => {
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  function handleSubmit(e) {


    const url = "http://localhost:8080/products"; 
    // prevent the page reloading
    e.preventDefault();

    // grab the data from the form
    const data = new FormData(e.target);

    const newProduct = {
        category: data.get("category"),
        quantity: data.get("quantity"),
        storageLocation: data.get("storageLocation"),
        warehouse_id: {
          id: data.get("warehouse_id")
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
      <h1>Create a Product</h1>

      <Form onSubmit={handleSubmit} className="form-container">
        <Label htmlFor="category">Product Category</Label>
        <TextInput id="category" name="category" type="text" />

        <div>
          <Label htmlFor="quantity">Quantity</Label>
          <TextInput id="quantity" name="quantity" type="number" />
        </div>

        <div>
          <Label htmlFor="storageLocation">Storage Location</Label>
          <TextInput id="storageLocation" name="storageLocation" type="text" />
        </div>

        <div>
          <Label htmlFor="warehouse_id">Warehouse</Label>
          <TextInput id="warehouse_id" name="warehouse_id" type="number" />
        </div>

        <Button type="submit">Submit</Button>

      </Form>
      {
        message && <Alert type="success" heading="Success status" headingLevel="h4">
          {message}
        </Alert>
      }

    </>
  )
}
