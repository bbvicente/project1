import { useState } from "react";
import { useEffect } from "react";
import { Grid, GridContainer, Table, Button } from '@trussworks/react-uswds';

const WarehouseList = () =>  {

    // TODO fetch data from backend and display in table
    // when the component is mounted

    const url = "http://localhost:8080/warehouses";

    const [warehouses, setWarehouses] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {


        fetch(url)
            .then(data => data.json()) 
            .then(returnedData => {
                setWarehouses(returnedData);
                setLoaded(true);
            })
            //.catch(err => { alert(err); console.log(err) })
            //<Alert type="error" heading="Error status" headingLevel="h4">{testText}</Alert>

    }, [])

    return (
        <>
            <div>
            <Button type="button" base>Add</Button>
            <GridContainer>
                <Grid row>
                    <Grid col="1"></Grid>
                    <Grid col="10">

                        <Table style={{ borderCollpase: true, borderColor: 0x000, borderWidth: 5 }} bordered fullWidth striped>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Capacity</th>
                                </tr>
                            </thead>
                            <tbody>
                                {loaded ?
                                    warehouse.map(
                                        warehouse => (
                                            <tr key={warehouse.id}>
                                                <td>{warehouse.name}</td>
                                                <td>{warehouse.city}</td>
                                                <td>{warehouse.state}</td>
                                                <td>{warehouse.capacity}</td>
                                            </tr>
                                        )) :
                                    (<tr><td colSpan='2'>Loading...</td></tr>)
                                }
                            </tbody>
                        </Table>
                    </Grid>
                    <Grid col="1"></Grid>

                </Grid>
            </GridContainer>
            </div>
        </>
    );
}

export default WarehouseList