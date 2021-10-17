import { Table } from "antd";
import Search from "antd/lib/input/Search";
import "antd/dist/antd.css";

function App() {
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
    { title: "State", dataIndex: "state", key: "state", filters: [{},] },
    { title: "Country Name", dataIndex: "countryName", key: "countryName", filterDropdown: stateSearch },
    { title: "Country Code", dataIndex: "countryCode", key: "countryCode" }
  ]
  return (
    <Table columns={columns} style={{ width: '75%', height: '100%', display: 'block', marginLeft: 'auto', marginRight: 'auto' }}>
    </Table >
  );
}

export default App;
