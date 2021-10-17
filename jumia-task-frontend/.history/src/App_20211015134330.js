import { Table } from "antd";
import Search from "antd/lib/input/Search";
import "antd/dist/antd.css";

function App() {
  const stateSearch = () => {
    return <div>
      <Search
        placeholder="search"
        onChange={e => console.log(e.target.value)}
        onPressEnter={console.log("search")}>
      </Search> </div>
  }
  const columns = [{ title: "State", dataIndex: "state", key: "state", filterDropdown: stateSearch }]
  return (
    <Table columns={columns} style={{ width: '75%', height: '50%', display: 'block', marginLeft: 'auto', marginRight: 'auto' }}>
    </Table >
  );
}

export default App;
