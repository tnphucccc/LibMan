interface SearchBarProps {
  searchQuery: string;
  setSearchQuery: (query: string) => void;
}

export default function SearchBar({ searchQuery, setSearchQuery }: SearchBarProps) {
  return (
    <div>
      <input
        className="w-96 h-10 rounded-lg p-2 font-semibold font-Inter text-Charcoal-Black text-sm shadow border-black border-2"
        value={searchQuery}
        onChange={(e) => setSearchQuery(e.target.value)}
        placeholder="Search..."
      />
    </div>
  );
};

