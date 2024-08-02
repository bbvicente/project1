import { useState } from 'react';
import { WarehouseForm } from '../components/WarehouseForm';
import { Button, GridContainer } from '@trussworks/react-uswds'
import WarehouseList from '../components/WarehouseList';
import { useNavigate } from "react-router-dom";
import { ProductForm } from '../components/ProductForm';

export default function Warehouses() {
  
  const [shouldRender1, setShouldRender1] = useState(0);
  const [shouldRender2, setShouldRender2] = useState(0);
  const navigate = useNavigate();

    return (<>
        <h1>Warehouses</h1>

        <main>
           
          <div>
            <Button onClick={() => navigate("/create-warehouse")} className = 'create-button' type="button" accentStyle="warm" >ADD WAREHOUSE</Button>
              {shouldRender1 ? <WarehouseForm />: null}
          </div>
          
          <GridContainer className="container-center" containerSize="desktop">
            <WarehouseList />
          </GridContainer>
     
        </main>
      </>)
  }