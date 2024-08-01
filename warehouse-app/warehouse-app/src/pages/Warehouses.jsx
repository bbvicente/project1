import { useState } from 'react';
import { WarehouseForm } from '../components/WarehouseForm';
// import { Button } from '@trussworks/react-uswds'

import { Button, GridContainer } from '@trussworks/react-uswds'
import WarehouseList from '../components/WarehouseList';

export default function Warehouses() {
  
  const [shouldRender, setShouldRender] = useState(0);

    return (<>
        <h1>Warehouses</h1>

        <main className="form-container">
            <Button onClick={() => setShouldRender(!shouldRender)} className = 'create-button' type="button" accentStyle="warm" >CREATE</Button>
            {shouldRender ? <WarehouseForm />: null}
            
            
          <GridContainer className="container-center" containerSize="desktop">
            <WarehouseList />
          </GridContainer>
     
        </main>
      </>)
  }