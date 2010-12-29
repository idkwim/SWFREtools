package tv.porst.swfretools.parser.tags;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.BinaryParserHelpers;
import tv.porst.swfretools.parser.structures.RecordHeader;

public class DefineBitsJPEG3Parser {

	public static Tag parse(final RecordHeader header, final BinaryParser parser) {
		final int characterId = parser.readUInt16();
		final int alphaDataOffset = (int) parser.readUInt32();
		final byte[] jpegData = BinaryParserHelpers.readByteArray(parser, alphaDataOffset);
		final byte[] bitmapAlphaData = BinaryParserHelpers.readByteArray(parser, header.getNormalizedLength() - alphaDataOffset);

		return new DefineBitsJPEG3Tag(header, characterId, jpegData, bitmapAlphaData);
	}

}
