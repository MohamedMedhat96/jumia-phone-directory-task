import { Table } from "antd";
import Search from "antd/lib/input/Search";

function App() {
  const stateSearch = () => {
    return <div>
      <Search
        placeholder="search"
        onChange={e => console.log(e.target.value)}
        onPressEnter={console.log("search")}>
      </Search> </div>
  }
  const columns = [{ title: "State", dataIndex: "state", key: "state", filterDropdown: }]
  return (
    <Table columns>

    </Table>
  );
}

export default App;
