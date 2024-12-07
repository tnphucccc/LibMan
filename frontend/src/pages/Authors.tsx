import axios from "axios";
import { useEffect, useState } from "react";
import Modal from "../components/Modal";
import AuthorCard from "../components/AuthorCard";
import CreateAuthorModal from "../components/CreateAuthorModal";
import UpdateAuthorModal from "../components/UpdateAuthorModal";
import AuthorDetailModal from "../components/AuthorDetailModal";

export default function Authors() {
  const [authorList, setAuthorList] = useState([]);
  const [isShowModalCreate, setIsShowModalCreate] = useState(false);
  const [isShowModalUpdate, setIsShowModalUpdate] = useState(false);
  const [isShowModalDetail, setIsShowModalDetail] = useState(false); // New state
  const [currentAuthor, setCurrentAuthor] = useState<any>();

  const handleOpenModalDetail = (author: any) => {
    setCurrentAuthor(author);
    setIsShowModalDetail(true);
  };

  const handleCloseModalDetail = () => setIsShowModalDetail(false);

  const handleGetAuthors = async () => {
    try {
      const res = await axios.get(import.meta.env.VITE_BASE_URL + "/authors");
      if (res.status === 200) {
        setAuthorList(res.data);
        console.log(res.data);
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleOpenModalCreate = () => {
    setIsShowModalCreate(true);
  };

  const handleCloseModalCreate = () => {
    setIsShowModalCreate(false);
  };

  const handleOpenModalUpdate = (author: any) => {
    setIsShowModalUpdate(true);
    setCurrentAuthor(author);
  };

  const handleCloseModalUpdate = () => {
    setIsShowModalUpdate(false);
  };

  const handleSubmitCreate = async ({
    name,
    nationality,
    portraitUrl,
  }: {
    name: string;
    nationality: string;
    portraitUrl: string;
  }) => {
    try {
      const res = await axios.post(import.meta.env.VITE_BASE_URL + "/authors", {
        name,
        nationality,
        portraitUrl,
      });

      if (res) {
        console.log(res.data);
        handleGetAuthors();
      }
    } catch (error) {
      console.error(error);
    }
    handleCloseModalCreate();
  };

  const handleSubmitUpdate = async ({
    name,
    nationality,
    portraitUrl,
  }: {
    name: string;
    nationality: string;
    portraitUrl: string;
  }) => {
    try {
      const res = await axios.put(
        import.meta.env.VITE_BASE_URL + "/authors/" + currentAuthor.authorId,
        {
          name,
          nationality,
          portraitUrl,
        }
      );

      if (res) {
        console.log(res.data);
        handleGetAuthors();
      }
    } catch (error) {
      console.error(error);
    }
    handleCloseModalUpdate();
  };

  const handleDelete = async (id: number) => {
    try {
      const res = await axios.delete(import.meta.env.VITE_BASE_URL + "/authors/" + id);
      if (res) {
        console.log(res.data);
        handleGetAuthors();
      }
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    handleGetAuthors();
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-center font-bold text-3xl">Author List</h2>
      <button
        className="absolute border-2 border-green-500 bg-green-500 text-white font-semibold p-2 hover:bg-white hover:text-black top-24 right-12 rounded-lg"
        onClick={() => handleOpenModalCreate()}
      >
        Add Author
      </button>
      <div className="flex flex-row flex-wrap w-full h-fit gap-6 mt-4 justify-center">
        {authorList.map((author: any) => (
          <AuthorCard
            key={author.authorId}
            author={author}
            handleOpenModalUpdate={handleOpenModalUpdate}
            handleDelete={handleDelete} 
            handleOpenAuthorDetail={handleOpenModalDetail}/>
        ))}
      </div>

      {/* Modal for creating author */}
      <Modal isShowModal={isShowModalCreate}>
        <CreateAuthorModal
          handleCloseModal={handleCloseModalCreate}
          handleSubmit={handleSubmitCreate}
        />
      </Modal>

      {/* Modal for updating author */}
      <Modal isShowModal={isShowModalUpdate}>
        <UpdateAuthorModal
          handleCloseModal={handleCloseModalUpdate}
          handleSubmit={handleSubmitUpdate}
          author={currentAuthor}
        />
      </Modal>

      {/* Modal for displaying author details */}
      <Modal isShowModal={isShowModalDetail}>
        <AuthorDetailModal handleCloseModal={handleCloseModalDetail} author={currentAuthor} />
      </Modal>
    </div>
  );
}
