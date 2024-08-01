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
                console.log(returnedData);
                setWarehouses(returnedData);
                setLoaded(true);
            })
            //.catch(err => { alert(err); console.log(err) })
            //<Alert type="error" heading="Error status" headingLevel="h4">{testText}</Alert>

    }, [])

    return (
        <>
            <div>
            <GridContainer>
                <Grid row>
                    <Grid col="1"></Grid>
                    <Grid col="10">

                        <Table bordered className="table-border">
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
                                    warehouses.map(
                                        warehouses => (
                                            <tr key={warehouses.id}>
                                                <td>{warehouses.name}</td>
                                                <td>{warehouses.city}</td>
                                                <td>{warehouses.state}</td>
                                                <td>{warehouses.capacity}</td>
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