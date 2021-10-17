import { Table } from "antd";
import Search from "antd/lib/input/Search";
import "antd/dist/antd.css";
import { useEffect, useState } from "react";

function App() {

  const [pagination, setPagination] = useState()

  useEffect(() => {

  }, [])

  const stateSearch = () => {
    return <div>
      <Search
        placeholder="Search"
        onChange={e => console.log(e.target.value)}
        onPressEnter={console.log("search")}>
      </Search> </div>
  }
  const columns = [
    { title: "ID", dataIndex: "id", key: "id" },
    { title: "Phone Number", dataIndex: "phoneNumber", key: "phoneNumber" },
    { title: "State", dataIndex: "state", key: "state", filters: [{ text: "True", value: "true" }, { text: "False", value: "false" }] },
    { title: "Country Name", dataIndex: "countryName", key: "countryName", filterDropdown: stateSearch },
    { title: "Country Code", dataIndex: "countryCode", key: "countryCode" }
  ]
  return (
    <Table
      columns={columns}
      style={{ width: '75%', height: '100%', display: 'block', marginLeft: 'auto', marginRight: 'auto' }}
      pagination={pagination}>
    </Table >
  );
}

export default App;
