
import { useState } from 'react';
import { Label, TextInput, Form, Button, Alert, Select } from "@trussworks/react-uswds";

{/** Form to update the info of a product */}
export const ProductUpdateForm = () => {
  const [message, setMessage] = useState("");
  const [error, setError] = useState("");
  function handleSubmit(e) {


    const url = "http://localhost:8080/products/"; 
    // prevent the page reloading
    e.preventDefault();

    // grab the data from the form
    const data = new FormData(e.target);

    const updatedProduct = {
        id: data.get("id"),
        category: data.get("category"),
        quantity: data.get("quantity"),
        storageLocation: data.get("storageLocation"),
        warehouse_id: {
          id: data.get("warehouse_id")
        }
    }

    e.target.reset();

    fetch(url + updatedProduct.id, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(updatedProduct)
    })
      .then(response => console.log(response)
      )
      .catch(err => {
        console.log(err);
        setError(err)
      });

  }

  return (
    <>
      <h1>Update a Product</h1>

      <Form onSubmit={handleSubmit} className="form-container">
        <Label htmlFor="id">Product ID</Label>
        <TextInput id="id" name="id" type="text" />
        
        <div>
        <Label htmlFor="category">Product Category</Label>
        <TextInput id="category" name="category" type="text" />
        </div>
        
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
