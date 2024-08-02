import { InventoryList } from '../components/InventoryList';
import { GridContainer } from '@trussworks/react-uswds'

export default function Inventory() {
    return (<>
      <h1>Current Inventory</h1>

        <main className="form-container">
            {/** List of the warehouse inventory */}
            <GridContainer className="container-center" containerSize="desktop">
              <InventoryList />
            </GridContainer>
      
        </main>
        </>)
  }