import { useState } from 'react';
import { Button, GridContainer } from '@trussworks/react-uswds'
import { useNavigate } from "react-router-dom";
import { ProductForm } from '../components/ProductForm';
import ProductList from '../components/ProductList';

export default function Products() {
  
  const [shouldRender1, setShouldRender1] = useState(0);
  const [shouldRender2, setShouldRender2] = useState(0);
  const navigate = useNavigate();

    return (<>
        <h1>Products</h1>

        <main>
           
            <div>
            <Button onClick={() => navigate("/create-product")} className = 'create-button' type="button" accentStyle="warm" >ADD PRODUCT</Button>
            {shouldRender2 ? <ProductForm />: null}
            </div>

            <GridContainer className="container-center" containerSize="desktop">
                <ProductList />
            </GridContainer>
     
        </main>
      </>)
}